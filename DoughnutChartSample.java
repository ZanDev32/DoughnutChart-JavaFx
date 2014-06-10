import javafx.application.Application;
import javafx.collections.*;
import javafx.geometry.Bounds;
import javafx.scene.*;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class DoughnutChartSample extends Application {
 
    @Override public void start(Stage stage) {
        stage.setTitle("Imported Fruits");
        stage.setWidth(500);
        stage.setHeight(500);

        ObservableList<PieChart.Data> pieChartData = createData();

        final DoughnutChart chart = new DoughnutChart(pieChartData);
        chart.setTitle("Imported Fruits");

        Scene scene = new Scene(new StackPane(chart));
        stage.setScene(scene);
        stage.show();
    }

    class DoughnutChart extends PieChart {
        private final Circle innerCircle;

        public DoughnutChart(ObservableList<PieChart.Data> pieData) {
            super(pieData);

            innerCircle = new Circle();

            // just styled in code for demo purposes,
            // use a style class instead to style via css.
            innerCircle.setFill(Color.WHITESMOKE);
            innerCircle.setStroke(Color.WHITE);
            innerCircle.setStrokeWidth(3);
        }

        @Override
        protected void layoutChartChildren(double top, double left, double contentWidth, double contentHeight) {
            super.layoutChartChildren(top, left, contentWidth, contentHeight);

            updateInnerCircleLayout(getData(), innerCircle);

            if (getData().size() > 0) {
                Node pie = getData().get(0).getNode();
                if (pie.getParent() instanceof Pane) {
                    Pane parent = (Pane) pie.getParent();

                    if (!parent.getChildren().contains(innerCircle)) {
                        parent.getChildren().add(innerCircle);
                    }
                }
            }
        }

        private void updateInnerCircleLayout(ObservableList<PieChart.Data> pieChartData, Circle innerCircle) {
            double minX = Double.MAX_VALUE, minY = Double.MAX_VALUE;
            double maxX = Double.MIN_VALUE, maxY = Double.MIN_VALUE;
            for (PieChart.Data data: pieChartData) {
                Node node = data.getNode();

                Bounds bounds = node.getBoundsInParent();
                if (bounds.getMinX() < minX) {
                    minX = bounds.getMinX();
                }
                if (bounds.getMinY() < minY) {
                    minY = bounds.getMinY();
                }
                if (bounds.getMaxX() > maxX) {
                    maxX = bounds.getMaxX();
                }
                if (bounds.getMaxY() > maxY) {
                    maxY = bounds.getMaxY();
                }
            }

            innerCircle.setCenterX(minX + (maxX - minX) / 2);
            innerCircle.setCenterY(minY + (maxY - minY) / 2);

            innerCircle.setRadius((maxX - minX) / 4);
        }
    }

    private ObservableList<PieChart.Data> createData() {
        return FXCollections.observableArrayList(
                new PieChart.Data("Grapefruit", 13),
                new PieChart.Data("Oranges", 25),
                new PieChart.Data("Plums", 10),
                new PieChart.Data("Pears", 22),
                new PieChart.Data("Apples", 30));
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
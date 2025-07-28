# DoughnutChart for JavaFX

This is a fork of [jewelsea's answer](https://stackoverflow.com/a/24134992) from Stack Overflow, which provides a custom JavaFX component for creating doughnut charts (pie charts with a hollow center).

## What's New

The main enhancement in this fork is the addition of a **no-argument constructor** to the `DoughnutChart` class, which enables:

- **FXML Compatibility**: The component can now be used directly in FXML files
- **Scene Builder Integration**: When packaged as a JAR, the component can be imported and used in Scene Builder for visual UI design

## Original Implementation

The original implementation by jewelsea provided a robust doughnut chart by extending JavaFX's `PieChart` and adding an inner circle to create the hollow center effect. The original code required passing data through the constructor, which prevented FXML usage.

## Key Features

- ✅ Extends JavaFX `PieChart` for full chart functionality
- ✅ Creates hollow center effect with customizable inner circle
- ✅ **NEW**: Default constructor for FXML compatibility
- ✅ **NEW**: Scene Builder support when packaged as JAR
- ✅ **NEW**: Maven build system for easy JAR generation
- ✅ Robust refresh mechanism with `refreshDoughnut()` method
- ✅ Automatic layout updates and proper error handling

## Maven Setup

This project uses Maven for dependency management and JAR generation. The `pom.xml` includes:

- JavaFX 17+
- Maven 

### Quick Start with Maven

```bash
# Clone the repository
git clone https://github.com/ZanDev32/DoughnutChart-JavaFx.git
cd DoughnutChart-JavaFx

# Build all JARs
mvn clean package

# Run the sample application
mvn javafx:run
```

## Usage

### In Java Code
```java
ObservableList<PieChart.Data> data = FXCollections.observableArrayList(
    new PieChart.Data("Category 1", 30),
    new PieChart.Data("Category 2", 50),
    new PieChart.Data("Category 3", 20)
);

DoughnutChart chart = new DoughnutChart(data);
// or
DoughnutChart chart = new DoughnutChart();
chart.setData(data);
```

### In FXML
```xml
<?xml version="1.0" encoding="UTF-8"?>
<?import doughnutchart.DoughnutChart?>
<?import javafx.scene.layout.VBox?>

<VBox xmlns="http://javafx.com/javafx/11.0.1" xmlns:fx="http://javafx.com/fxml/1">
   <children>
      <DoughnutChart fx:id="doughnutChart" />
   </children>
</VBox>
```

### In Scene Builder
1. Package the project as a JAR file
2. Import the JAR in Scene Builder
3. Drag and drop the `DoughnutChart` component from the custom components section

## Credits

- Original implementation: [jewelsea on Stack Overflow](https://stackoverflow.com/a/24134992)

## License

This code follows the same licensing terms as the original Stack Overflow contribution.

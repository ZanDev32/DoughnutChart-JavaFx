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

- JavaFX 17.0.2 dependencies
- Maven Shade Plugin for creating fat JARs with all dependencies
- Source JAR generation
- Special Scene Builder profile
- Java 11 compatibility

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

## Building for Scene Builder

To use this component in Scene Builder:

### Option 1: Use the regular JAR (Recommended for Scene Builder)
```bash
mvn clean package
```
This generates `target/doughnutchart-javafx-1.0.0.jar` which is perfect for Scene Builder.

### Option 2: Use the Scene Builder specific profile
```bash
mvn clean package -Pscenebuilder
```
This generates `target/doughnutchart-javafx-1.0.0-scenebuilder.jar` optimized for Scene Builder.

### Available JAR Files

After building, you'll find these JAR files in the `target` directory:

- **`doughnutchart-javafx-1.0.0.jar`** - Regular JAR (7.8KB) - **Best for Scene Builder**
- **`doughnutchart-javafx-1.0.0-fat.jar`** - Fat JAR with all dependencies (8.1MB) - For standalone applications
- **`doughnutchart-javafx-1.0.0-sources.jar`** - Source code JAR
- **`doughnutchart-javafx-1.0.0-scenebuilder.jar`** - Scene Builder optimized JAR (when using the profile)

### Scene Builder Integration Steps

1. Build the project: `mvn clean package`
2. In Scene Builder, go to `Library` → `JAR/FXML Manager`
3. Add `target/doughnutchart-javafx-1.0.0.jar` to make the `DoughnutChart` component available
4. The component will appear in the custom components section

### Running the Sample Application

To run the included sample application:
```bash
mvn javafx:run
```

Or run the fat JAR directly:
```bash
java -jar target/doughnutchart-javafx-1.0.0-fat.jar
```

## GitHub Actions CI/CD

This project includes automated GitHub Actions workflows:

### 🔄 Build Workflow
- **Trigger:** Every push and pull request to master/main
- **Tests:** Java 11, 17, and 21 compatibility
- **Actions:** Compiles, tests, and builds all JAR variants
- **Artifacts:** Uploads JAR files for 5 days

### 🚀 Release Workflow
- **Trigger:** When you push a version tag (e.g., `v1.0.0`)
- **Actions:** Builds all JARs and creates a GitHub release
- **Assets:** Automatically uploads all JAR variants to the release

### Creating a Release
To create a new release:

```bash
# Tag your commit with a version
git tag v1.0.1
git push origin v1.0.1

# GitHub Actions will automatically:
# 1. Build all JAR files
# 2. Create a GitHub release  
# 3. Upload JAR files as release assets
# 4. Generate release notes
```

## Credits

- Original implementation: [jewelsea on Stack Overflow](https://stackoverflow.com/a/24134992)
- FXML enhancement: This fork

## License

This code follows the same licensing terms as the original Stack Overflow contribution.
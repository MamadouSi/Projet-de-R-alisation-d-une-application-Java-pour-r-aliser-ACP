package da.project.acp;

import java.util.ArrayList;

import da.project.math_box.Vector;

public interface IAcp {
public void printData();

public ArrayList<Vector> getComponents(double information_percentage);
public void printComponents();
public void drawData();
public void drawComponents();
public void printEigenComponents();
public void printCorrelationMatrix();


}

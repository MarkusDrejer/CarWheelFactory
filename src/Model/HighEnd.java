package Model;

public class HighEnd implements IWheel {

    private String name = "High Quality Wheel";
    private int assemblyTime = 17000;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAssemblyTime() {
        return assemblyTime;
    }
}

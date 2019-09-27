package Model;

public class Normal implements IWheel {

    private String name = "Normal Wheel";
    private int type = 1;
    private int assemblyTime = 10000;

    @Override
    public int getType() {
        return type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAssemblyTime() {
        return assemblyTime;
    }
}

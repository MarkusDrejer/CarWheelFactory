package Model;

public class Winter implements IWheel {

    private String name = "Winter Wheel";
    private int type = 2;
    private int assemblyTime = 14000;

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

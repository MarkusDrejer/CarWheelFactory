package Model;

public class HighEnd implements IWheel {

    private String name = "High End Wheel";
    private int type = 3;
    private int assemblyTime = 17000;

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

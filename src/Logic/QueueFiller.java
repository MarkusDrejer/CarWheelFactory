package Logic;

import Data.DataContainer;
import Model.HighEnd;
import Model.Normal;
import Model.Winter;

public class QueueFiller {

    public void addToData(int wheelType, int wheelAmount) {
        for(int i = 0; i < wheelAmount; i++) {
            switch (wheelType) {
                case 1:
                    addNormal();
                    break;
                case 2:
                    addWinter();
                    break;
                case 3:
                    addHighEnd();
                    break;
            }
        }
    }

    private void addNormal() {
        DataContainer.addToList(new Normal());
    }

    private void addWinter() {
        DataContainer.addToList(new Winter());
    }

    private void addHighEnd() {
        DataContainer.addToList(new HighEnd());
    }
}
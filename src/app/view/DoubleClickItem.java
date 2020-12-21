package app.view;

import app.event.MoveToChildren;
import app.event.OnItemSelected;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class DoubleClickItem implements EventHandler<MouseEvent> {
    private static final int COUNT_CLICK = 2;
    private final MoveToChildren moveToChildren;
    private final OnItemSelected onItemSelected;

    public DoubleClickItem(MoveToChildren moveToChildren, OnItemSelected onItemSelected) {
        this.moveToChildren = moveToChildren;
        this.onItemSelected = onItemSelected;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if (COUNT_CLICK == mouseEvent.getClickCount()) {
            this.moveToChildren.moveToChildren();
        } else {
            this.onItemSelected.onItemSelected();
        }
    }
}

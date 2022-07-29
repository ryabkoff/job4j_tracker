package ru.job4j.tracker;

import java.util.List;

public class DeleteManyItemsAction implements UserAction {

    private final Output out;

    public DeleteManyItemsAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete many items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Delete many items ===");
        List<Item> list = tracker.findAll();
        int counter = 0;
        for (Item item : list) {
            tracker.delete(item.getId());
            counter++;
            if (counter == 10000) {
                break;
            }
        }
        out.println("Всего заявок = " + tracker.findAll().size());
        return true;
    }
}

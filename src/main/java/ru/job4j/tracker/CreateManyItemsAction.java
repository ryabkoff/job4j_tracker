package ru.job4j.tracker;

public class CreateManyItemsAction implements UserAction {

    private final Output out;

    public CreateManyItemsAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Create many items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Create many items ====");
        for (int i = 0; i < 10000; i++) {
            tracker.add(new Item(Integer.toString(i)));
        }
        out.println("Всего заявок = " + tracker.findAll().size());
        return true;
    }
}

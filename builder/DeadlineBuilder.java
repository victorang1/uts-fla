package builder;

import model.Deadline;

public class DeadlineBuilder {
    
    private Deadline deadline;
    
    public DeadlineBuilder() {
        deadline = new Deadline();
    }

    public DeadlineBuilder addDays(int days) {
        this.deadline.addDays(days);
        return this;
    }

    public DeadlineBuilder addMonth(int months) {
        this.deadline.addMonths(months);
        return this;
    }

    public Deadline build() {
        return deadline;
    }
}

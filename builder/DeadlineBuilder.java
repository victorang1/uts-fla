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

    public DeadlineBuilder addOneDay() {
        this.deadline.tommorrow();
        return this;
    }

    public DeadlineBuilder addOneWeek() {
        this.deadline.nextWeek();
        return this;
    }

    public DeadlineBuilder addOneMonth() {
        this.deadline.nextMonth();
        return this;
    }

    public Deadline build() {
        return deadline;
    }
}

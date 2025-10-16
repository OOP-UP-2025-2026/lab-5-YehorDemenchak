package ua.opnu;

public class TimeSpan {

    private int hours;
    private int minutes;

    public TimeSpan() {
        this.hours = 0;
        this.minutes = 0;
    }

    public TimeSpan(int minutes) {
        checkForIllegalArguments(minutes);

        this.hours = 0;
        this.minutes = minutes;
    }

    public TimeSpan(int hours, int minutes) {
        checkForIllegalArguments(hours, minutes);

        this.hours = hours;
        this.minutes = minutes;
    }

    public TimeSpan(TimeSpan t) {
        checkForIllegalArguments(t);

        this.hours = t.hours;
        this.minutes = t.minutes;
    }

    public int getHours() {
        return this.hours;
    }

    public int getMinutes() {
        return this.minutes;
    }

    public void add(int minutes) {
        checkForIllegalArguments(minutes);

        this.minutes += minutes;

        if (this.minutes > 59) {
            this.hours += this.minutes / 60;
            this.minutes = this.minutes % 60;
        }
    }

    public void add(int hours, int minutes) {
        checkForIllegalArguments(hours, minutes);

        this.minutes += minutes;
        this.hours += hours;

        if (this.minutes > 59) {
            this.hours += this.minutes / 60;
            this.minutes = this.minutes % 60;
        }
    }

    public void add(TimeSpan t) {
        checkForIllegalArguments(t);

        this.minutes += t.minutes;
        this.hours += t.hours;

        if (this.minutes > 59) {
            this.hours += this.minutes / 60;
            this.minutes = this.minutes % 60;
        }
    }

    public void addTimeSpan(TimeSpan timespan) {
        add(timespan.getHours(), timespan.getMinutes());
    }

    public double getTotalHours() {
        return this.hours + (this.minutes / 60.0);
    }

    public int getTotalMinutes() {
        return this.hours * 60 + this.minutes;
    }

    public void subtract(int minutes) {
        int currentTotalMinutes = this.getTotalMinutes();

        if (minutes > currentTotalMinutes) {
            throw new IllegalArgumentException("Can't subtract larger timespan from smaller one");
        }

        int resultMinutes = currentTotalMinutes - minutes;

        this.hours = resultMinutes / 60;
        this.minutes = resultMinutes % 60;
    }

    public void subtract(int hours, int minutes) {
        int currentTotalMinutes = this.getTotalMinutes();
        int argumentTotalMinutes = hours * 60 + minutes;

        if (argumentTotalMinutes > currentTotalMinutes) {
            throw new IllegalArgumentException("Can't subtract larger timespan from smaller one");
        }

        int resultMinutes = currentTotalMinutes - argumentTotalMinutes;

        this.hours = resultMinutes / 60;
        this.minutes = resultMinutes % 60;
    }

    public void subtract(TimeSpan t) {
        int currentTotalMinutes = this.getTotalMinutes();
        int spanTotalMinutes = t.getTotalMinutes();

        if (spanTotalMinutes > currentTotalMinutes) {
            throw new IllegalArgumentException("Can't subtract larger timespan from smaller one");
        }

        int resultMinutes = currentTotalMinutes - spanTotalMinutes;

        this.hours = resultMinutes / 60;
        this.minutes = resultMinutes % 60;
    }

    public void scale(int factor) {
        if (factor <= 0) {
            throw new IllegalArgumentException("Factor must be greater than zero");
        }

        int totalMinutes = this.getTotalMinutes();
        totalMinutes *= factor;

        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }

    public void checkForIllegalArguments(int minutes) {
        if (minutes < 0) {
            throw new IllegalArgumentException("Time span can't be negative");
        }

        if (minutes > 59) {
            throw new IllegalArgumentException("Minutes can be between 0 and 59");
        }
    }

    public void checkForIllegalArguments(int hours, int minutes) {
        if (hours < 0 || minutes < 0) {
            throw new IllegalArgumentException("Time span can't be negative");
        }

        if (minutes > 59) {
            throw new IllegalArgumentException("Minutes can be between 0 and 59");
        }
    }

    public void checkForIllegalArguments(TimeSpan t) {
        if (t.hours < 0 || t.minutes < 0) {
            throw new IllegalArgumentException("Time span can't be negative");
        }

        if (t.minutes > 59) {
            throw new IllegalArgumentException("Minutes can be between 0 and 59");
        }
    }
}

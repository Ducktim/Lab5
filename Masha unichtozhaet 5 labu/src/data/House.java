package data;

/**
 * class for person who has flat.
 */
public class House implements Comparable<House>{
    private final String  name; //Поле не может быть null
    private final Long year; //Значение поля должно быть больше 0
    private final Integer numberOfFlatsOnFloor; //Значение поля должно быть больше 0
    private final Long numberOfLifts; //Значение поля должно быть больше 0

    public House(String  name, long year, Integer numberOfFlatsOnFloor, long numberOfLifts){
        this.name = name;
        this.year = year;
        this.numberOfLifts = numberOfLifts;
        this.numberOfFlatsOnFloor = numberOfFlatsOnFloor;
    }

    /**
     * @return name of house
     */
    public String getName() {
        return name;
    }

    /**
     * @return year of house
     */
    public Long getYear() {
        return year;
    }

    /**
     * @return number of flats on floor in house
     */
    public Integer getNumberOfFlatsOnFloor() {
        return numberOfFlatsOnFloor;
    }

    /**
     * @return number of lifts in house
     */
    public Long getNumberOfLifts() {
        return numberOfLifts;
    }

    @Override
    public String toString() {
        return "\n Name: " + getName() + "\n" +
                " Year: " + getYear() + "\n" +
                " Num. of lifts: " + getNumberOfLifts() + "\n" +
                " Num. of flats on floor: " + getNumberOfFlatsOnFloor();
    }
    /**
     * Compares person with each other.
     * @param o - the object with which the comparison takes place
     * @return int>0, if this>o. int=0, if this=o. int<0, if this<0.
     */
    public int compareTo(House o) {
        int res = this.name.compareTo(o.name);
        if(res==0){
            res = this.year.compareTo(o.year);
            if (res == 0) {
                res = this.numberOfFlatsOnFloor.compareTo(o.numberOfFlatsOnFloor);
                if(res==0){
                    res = this.numberOfLifts.compareTo(o.numberOfLifts);
                }
            }
        }
        return res;
    }
}
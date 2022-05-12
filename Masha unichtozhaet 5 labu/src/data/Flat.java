package data;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Admin class for Flat
 */
public class Flat implements Comparable<Flat> {
    static long newId = 0;
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private final String name; //Поле не может быть null, Строка не может быть пустой
    private final Coordinates coordinates; //Поле не может быть null
    private final LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private final Float area; //Значение поля должно быть больше 0
    private final Long numberOfRooms; //Значение поля должно быть больше 0
    private final Float livingSpace; //Значение поля должно быть больше 0
    private final View view; //Поле может быть null
    private final Transport transport; //Поле может быть null
    private final House house; //Поле не может быть nullЗначение этого поля должно быть

    /**
     * Class constructor
     *
     * @param name          - name of flat
     * @param coordinates   - coordinates of flat
     * @param area          - area of flat
     * @param numberOfRooms - number of rooms inf flat
     * @param livingSpace   - living space of flat
     * @param view          - view from flat
     * @param transport     - transport
     * @param house         - house
     */

    public Flat(String name, Coordinates coordinates, Float area, Long numberOfRooms, Float livingSpace, View view, Transport transport, House house) {
        newId +=1;
        this.id = Math.toIntExact(newId);
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = LocalDateTime.now();
        this.area = area;
        this.numberOfRooms = numberOfRooms;
        this.livingSpace = livingSpace;
        this.view = view;
        this.transport = transport;
        this.house = house;
    }

    /**
     * Converts an object to a string representation.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "ID:\t" + id + "\n" +
                "Name:\t" + name + "\n" +
                "Coordinates:\t" + coordinates + "\n" +
                "Creation Date:\t" + creationDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) + "\n" +
                "Area:\t" + area + "\n" +
                "Number of rooms:\t" + numberOfRooms + "\n" +
                "Living space:\t" + livingSpace + "\n" +
                "View:\t" + view + "\n" +
                "Transport:\t" + transport + "\n" +
                "House:\t" + house + "\n";
    }

    /**
     * Compares two objects across all fields
     *
     * @param o - the object we want to compare with
     * @return boolean. True if objects are equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flat flat = (Flat) o;
        return id.equals(flat.id) &&
                name.equals(flat.getName()) &&
                coordinates.equals(flat.getCoordinates()) &&
                creationDate.equals(flat.getCreationDate()) &&
                area.equals(flat.getArea()) &&
                numberOfRooms.equals(flat.getNumberOfRooms()) &&
                livingSpace.equals(flat.getLivingSpace()) &&
                view.equals(flat.getView()) &&
                transport.equals(flat.getTransport()) &&
                house.equals(flat.getHouse());
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, area, numberOfRooms, livingSpace);
    }

    @Override
    public int compareTo(Flat o){
        int result = this.name.compareTo(o.name);
        if (result ==0){
            result = this.coordinates.compareTo(o.coordinates);
            if (result==0){
                result=this.creationDate.compareTo(o.creationDate);
                if (result==0){
                    result= this.area.compareTo(o.area);
                    if (result==0){
                        result=this.numberOfRooms.compareTo(o.numberOfRooms);
                        if (result ==0){
                            result=this.livingSpace.compareTo(o.livingSpace);
                        }
                    }
                }
            }
    }
        return result;
    }

    /**
     * @return name of flat.
     */
    public String getName() {
        return name;
    }

    /**
     * @return coordinates of flat.
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * @return creation date of flat.
     */
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    /**
     * @return area of flat.
     */
    public Float getArea () {
        return area;
    }

    /**
     * @return number of rooms in flat.
     */
    public Long getNumberOfRooms() {
        return numberOfRooms;
    }

    /**
     * @return living space of flat.
     */
    public Float getLivingSpace () {
        return livingSpace;
    }

    /**
     * @return view from flat.
     */
    public View getView() {
        return view;
    }

    /**
     * @return transport.
     */
    public Transport getTransport() {
        return transport;
    }

    /**
     * @return house.
     */
    public House getHouse() {
        return house;
    }

    /**
     * @return id of flat.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the unique id to existing flat.
     */
    public void setId() {
        try {
            this.id = Math.toIntExact(SecureRandom.getInstanceStrong().nextInt()); // Уникальный != случайный
        } catch (java.security.NoSuchAlgorithmException e) {
            System.out.println("No such algorithm");
        }
    }
}
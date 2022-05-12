package utility;

import data.Flat;

public class Validator {
    /**
     * Validates the element of collection for correct values.
     *
     * @param collectionManager collection
     * @param flat element
     * @return true if valid, else false.
     */
    public static boolean validate(CollectionManager collectionManager, Flat flat) {
        if(flat.getId() == null || flat.getId() <= 0 || (collectionManager.get(flat.getId()) != null)) {
            System.out.println("ID: " + flat.getId() + ". Element exists, skipping it.");
        } else if(flat.getName() == null) {
            System.out.println("ID: " + flat.getId() + ". Name can't be null.");
        } else if(flat.getCoordinates() == null) {
            System.out.println("ID: " + flat.getId() + ". Coordinates can't be null.");
        } else if(flat.getCoordinates().getX() == null || flat.getCoordinates().getY() <= -384) {
            System.out.println("ID: " + flat.getId() + ". Coordinates are incorrect.");
        } else if(flat.getCreationDate() == null) {
            System.out.println("ID: " + flat.getId() + ". Creation date can't be null.");
        } else if(flat.getArea() <= 0) {
            System.out.println("ID: " + flat.getId() + ". Area must be positive.");
        } else if(flat.getNumberOfRooms() <= 0) {
            System.out.println("ID: " + flat.getId() + ". Num. of rooms must be positive.");
        } else if(flat.getLivingSpace() <= 0) {
            System.out.println("ID: " + flat.getId() + ". Living space must be positive.");
        } else if(flat.getView() == null) {
            System.out.println("ID: " + flat.getId() + ". View can't be null.");
        } else if(flat.getTransport() == null) {
            System.out.println("ID: " + flat.getId() + ". Transport can't be null.");
        } else if(flat.getHouse() == null) {
            System.out.println("ID: " + flat.getId() + ". House can't be null.");
        } else if(flat.getHouse().getName() == null
                || flat.getHouse().getYear() <= 0
                || flat.getHouse().getNumberOfFlatsOnFloor() <= 0
                || flat.getHouse().getNumberOfLifts() <= 0) {
            System.out.println("ID: " + flat.getId() + ". House are incorrect.");
        } else {
            return true;
        }
        return false;
    }
}

class Video {
    private String title;
    private boolean isCheckedOut;
    private double averageRating;
    private int ratingCount;

    public Video(String title) {
        this.title = title;
        this.isCheckedOut = false;
        this.averageRating = 0.0;
        this.ratingCount = 0;
    }

    public void checkOut() {
        if (!isCheckedOut) {
            isCheckedOut = true;
            System.out.println(title + " has been checked out.");
        } else {
            System.out.println(title + " is already checked out.");
        }
    }

    public void returnVideo() {
        if (isCheckedOut) {
            isCheckedOut = false;
            System.out.println(title + " has been returned.");
        } else {
            System.out.println(title + " was not checked out.");
        }
    }

    public void receiveRating(int rating) {
        if (rating < 1 || rating > 5) {
            System.out.println("Rating must be between 1 and 5.");
            return;
        }
        averageRating = ((averageRating * ratingCount) + rating) / (ratingCount + 1);
        ratingCount++;
        System.out.println("Rating of " + rating + " has been added to " + title + ".");
    }

    public String getDetails() {
        return "Title: " + title + ", Checked Out: " + isCheckedOut + ", Average Rating: " + averageRating;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }
}

class VideoStore {
    private Video[] inventory;
    private int count;

    public VideoStore() {
        inventory = new Video[10];
        count = 0;
    }

    public void addVideo(String title) {
        if (count < inventory.length) {
            inventory[count++] = new Video(title);
            System.out.println("Video titled \"" + title + "\" added to inventory.");
        } else {
            System.out.println("Inventory full. Cannot add more videos.");
        }
    }

    public void checkOut(String title) {
        Video video = findVideo(title);
        if (video != null) {
            video.checkOut();
        } else {
            System.out.println("Video titled \"" + title + "\" not found in inventory.");
        }
    }

    public void returnVideo(String title) {
        Video video = findVideo(title);
        if (video != null) {
            video.returnVideo();
        } else {
            System.out.println("Video titled \"" + title + "\" not found in inventory.");
        }
    }

    public void receiveRating(String title, int rating) {
        Video video = findVideo(title);
        if (video != null) {
            video.receiveRating(rating);
        } else {
            System.out.println("Video titled \"" + title + "\" not found in inventory.");
        }
    }

    public void listInventory() {
        System.out.println("Inventory List:");
        for (int i = 0; i < count; i++) {
            System.out.println(inventory[i].getDetails());
        }
    }

    private Video findVideo(String title) {
        for (int i = 0; i < count; i++) {
            if (inventory[i].getTitle().equalsIgnoreCase(title)) {
                return inventory[i];
            }
        }
        return null;
    }
}

public class Experiment2 {
    public static void main(String[] args) {
        VideoStore store = new VideoStore();

        store.addVideo("The Matrix");
        store.addVideo("Godfather II");
        store.addVideo("Star Wars Episode IV: A New Hope");

        store.receiveRating("The Matrix", 5);
        store.receiveRating("The Matrix", 4);
        store.receiveRating("Godfather II", 5);
        store.receiveRating("Star Wars Episode IV: A New Hope", 3);

        store.checkOut("The Matrix");
        store.returnVideo("The Matrix");
        store.checkOut("Godfather II");

        store.listInventory();
}
}
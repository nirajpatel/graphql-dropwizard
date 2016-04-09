package sandbox;

/**
 * Created by Shanshan Jiang on 4/9/2016.
 */
public class Human {
    int id;
    String name;
    Human friends;

    // Getters are reflectively called by GraphQL lib
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Human getFriends() {
        return friends;
    }

    public void setFriends(Human friends) {
        this.friends = friends;
    }
}


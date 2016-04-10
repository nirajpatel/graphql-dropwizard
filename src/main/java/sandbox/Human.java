package sandbox;

import java.util.List;

/**
 * Created by Shanshan Jiang on 4/9/2016.
 */
public class Human {
    int id;
    String name;
    List<Human> friends;

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

    public List getFriends() {
        return friends;
    }

    public void setFriends(List<Human> friends) {
        this.friends = friends;
    }
}


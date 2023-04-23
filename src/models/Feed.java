package models;

import java.time.LocalDateTime;

public abstract class Feed {
    long id;
    User created_by;
    LocalDateTime created_time;
    int likes;
    int dislikes;
}

package com.example.springboot.assignment.supermarket.supermarket.entity;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "items")
@Getter
@Setter
@NoArgsConstructor
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private int itemId;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "cost")
    private int cost;

    @Column(name = "company")
    private String company;


    @ManyToMany(fetch = FetchType.LAZY,
    cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
            name = "orders",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "username")
    )
    @ToString.Exclude
    private List<Users> users;

    public Items(String itemName, int cost, String company) {
        this.itemName = itemName;
        this.cost = cost;
        this.company = company;
    }

    public Items(int itemId, String itemName, int cost, String company) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.cost = cost;
        this.company = company;
    }

    public void addUser(Users theUser)
    {
        if (users==null)
        {
            users=new ArrayList<>();
        }
        users.add(theUser);
    }
}

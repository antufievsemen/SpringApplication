package ru.antufiev.application.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

@Entity
public class Ticket {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer ticketId;

  private String title;
  private String description;

  @ManyToOne
  @JoinColumn(name = "id")
  private Application application;

  @ManyToOne
  @JoinTable(name = "ticket_release",
    joinColumns = @JoinColumn(name = "ticket_fk"),
    inverseJoinColumns = @JoinColumn(name = "release_fk"))
  private Release release;

  private String status;

  public Ticket () {}

  public Ticket(Integer ticketId, String title, String description, Application application, Release release, String status) {
    this.ticketId = ticketId;
    this.title = title;
    this.description = description;
    this.application = application;
    this.release = release;
    this.status = status;
  }

  public Integer getId() {
    return ticketId;
  }

  public void setId(Integer id) {
    this.ticketId = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Application getApplication() {
    return application;
  }

  public void setApplication(Application application) {
    this.application = application;
  }

  public Release getRelease() {
    return release;
  }

  public void setRelease(Release release) {
    this.release = release;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}

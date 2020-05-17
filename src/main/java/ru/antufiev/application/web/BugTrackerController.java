package ru.antufiev.application.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.antufiev.application.entity.Application;
import ru.antufiev.application.entity.Ticket;
import ru.antufiev.application.exception.ApplicationNotFoundException;
import ru.antufiev.application.service.ApplicationService;
import ru.antufiev.application.service.TicketService;

import java.util.List;

@RestController
@RequestMapping("/bt")
public class BugTrackerController {

  private ApplicationService applicationService;
  private TicketService ticketService;

  @PostMapping(value = "/addApplication", consumes = "application/json", produces = "application/json")
  public Application addApplication (@RequestBody Application newApp)  {
    return applicationService.addApplication(newApp);
  }

  @GetMapping("/applications")
  public ResponseEntity<List<Application>> getAllApplications() {
    List<Application> list = applicationService.listApplication();
    return new ResponseEntity<>(list, HttpStatus.OK);
  }

  @GetMapping("/application/{id}")
  public ResponseEntity<Application> getApplication(@PathVariable("id")Long id) {
    try{
      return new ResponseEntity<>(applicationService.findApplication(id), HttpStatus.OK);
    } catch (ApplicationNotFoundException exception) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Application not found");
    }
  }

  @GetMapping("/tickets")
  public ResponseEntity<List<Ticket>> getAllTickets() {
    List<Ticket> list = ticketService.listTickets();
    return new ResponseEntity<>(list, HttpStatus.OK);
  }

  @Autowired
  public void setApplicationService(ApplicationService applicationService) {
    this.applicationService = applicationService;
  }

  @Autowired
  public void setTicketService(TicketService ticketService) {
    this.ticketService = ticketService;
  }
}

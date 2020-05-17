package ru.antufiev.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.antufiev.application.entity.Ticket;
import ru.antufiev.application.repository.TicketRepository;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService{

  @Autowired
  private TicketRepository ticketRepository;

  @Override
  public List<Ticket> listTickets() {
    return (List<Ticket>) ticketRepository.findAll();
  }
}

package ru.antufiev.application.service;

import ru.antufiev.application.entity.Ticket;

import java.util.List;

public interface TicketService {
  List<Ticket> listTickets();
}

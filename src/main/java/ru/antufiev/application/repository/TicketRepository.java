package ru.antufiev.application.repository;

import org.springframework.data.repository.CrudRepository;
import ru.antufiev.application.entity.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Long> {}

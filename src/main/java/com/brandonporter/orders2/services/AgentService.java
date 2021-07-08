package com.brandonporter.orders2.services;

import com.brandonporter.orders2.models.Agent;

import java.util.List;

public interface AgentService {
    List<Agent> getAll();

    Agent getAgent(Long id);

    void deleteAgent(long id);
}

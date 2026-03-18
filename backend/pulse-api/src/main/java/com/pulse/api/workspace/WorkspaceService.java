package com.pulse.api.workspace;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WorkspaceService {

    private final WorkspaceRepository workspaceRepository;

    public WorkspaceService(WorkspaceRepository workspaceRepository) {
        this.workspaceRepository = workspaceRepository;
    }

    public Workspace createWorkspace(String name) {

        workspaceRepository.findByName(name)
            .ifPresent(w -> {
                throw new RuntimeException("Workspace with that name already exists");
            });

        Workspace workspace = new Workspace();
        workspace.setName(name);

        return workspaceRepository.save(workspace);
    }

    public Workspace getWorkspaceById(Long id) {
        return workspaceRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Workspace not found"));
    }

    public List<Workspace> getAllWorkspaces() {
        return workspaceRepository.findAll();
    }

    public void deleteWorkspace(Long id) {

    if (!workspaceRepository.existsById(id)) {
        throw new RuntimeException("Workspace not found");
    }

    workspaceRepository.deleteById(id);
    }
}
package ru.Belov.LastProject3.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.Belov.LastProject3.Models.RequestsModel;

@Repository
public interface RequestsRepositories extends JpaRepository<RequestsModel,Integer> {
}

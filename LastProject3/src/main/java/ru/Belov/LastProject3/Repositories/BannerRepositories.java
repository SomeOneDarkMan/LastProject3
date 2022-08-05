package ru.Belov.LastProject3.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.Belov.LastProject3.Models.BannerModel;
import ru.Belov.LastProject3.Models.RequestsModel;

@Repository
public interface BannerRepositories extends JpaRepository<BannerModel,Integer> {
}

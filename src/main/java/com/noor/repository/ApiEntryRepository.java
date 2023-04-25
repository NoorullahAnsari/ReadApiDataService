package com.noor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.noor.entity.ApiDataEntity;

@Repository
public interface ApiEntryRepository extends JpaRepository<ApiDataEntity, Long> {
}

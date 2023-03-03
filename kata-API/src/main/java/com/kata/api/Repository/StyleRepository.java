package com.kata.api.Repository;

import com.kata.api.Model.Styles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StyleRepository extends JpaRepository<Styles, Long>{
}

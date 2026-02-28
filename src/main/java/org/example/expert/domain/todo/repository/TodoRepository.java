package org.example.expert.domain.todo.repository;

import org.example.expert.domain.todo.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long>, TodoCustomRepository {

    @Query("SELECT t FROM Todo t LEFT JOIN FETCH t.user u ORDER BY t.modifiedAt DESC")
    Page<Todo> findAllByOrderByModifiedAtDesc(Pageable pageable);

    @Query("""
    select t
    from Todo t
    join fetch t.user
    where (:weather is null or t.weather like concat('%', :weather, '%'))
      and (:start is null or t.modifiedAt >= :start)
      and (:end is null or t.modifiedAt <= :end)
    order by t.modifiedAt desc
""")
    List<Todo> search(
            @Param("weather") String weather,
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end,
            Pageable pageable
    );

    @Query("""
    select count(t)
    from Todo t
    where (:weather is null or t.weather like concat('%', :weather, '%'))
      and (:start is null or t.modifiedAt >= :start)
      and (:end is null or t.modifiedAt <= :end)
""")
    long countSearch(
            @Param("weather") String weather,
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end
    );
}

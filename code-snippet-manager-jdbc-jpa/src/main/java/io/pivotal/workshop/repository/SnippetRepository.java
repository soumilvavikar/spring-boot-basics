package io.pivotal.workshop.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import io.pivotal.workshop.domain.Snippet;

import java.sql.Date;
import java.util.List;

@Transactional
public interface SnippetRepository extends CrudRepository<Snippet, String> {

	Snippet findByTitleLike(String title);

	List<Snippet> findByCreatedBetween(Date startDate, Date endDate);
}

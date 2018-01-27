package io.pivotal.workshop.repository;

import io.pivotal.workshop.domain.Snippet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SnippetRepository {

	private final JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT =
			"insert into snippet(id,title,code,created,modified) values(?,?,?,?,?)";
	private final String SQL_QUERY_ALL = "select * from snippet";
	private final String SQL_QUERY_BY_ID = "select * from snippet where id=?";

	private final RowMapper<Snippet> rowMapper = (ResultSet rs, int row) -> {
		Snippet snippet = new Snippet();
		snippet.setId(rs.getString("id"));
		snippet.setTitle(rs.getString("title"));
		snippet.setCode(rs.getString("code"));
		snippet.setCreated(rs.getDate("created"));
		snippet.setModified(rs.getDate("modified"));
		return snippet;
	};

	@Autowired
	public SnippetRepository(JdbcTemplate template) {
		this.jdbcTemplate = template;
	}

	public Snippet save(Snippet _snippet) {
		assert _snippet.getTitle() != null;
		assert _snippet.getCode() != null;

		final Long createdTime, modifiedTime;
		if (null != _snippet.getCreated()) {
			createdTime = _snippet.getCreated().getTime();
		}
		else {
			createdTime = new java.util.Date().getTime();
		}
		if (null != _snippet.getModified()) {
			modifiedTime = _snippet.getModified().getTime();
		}
		else {
			modifiedTime = new java.util.Date().getTime();
		}
		this.jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(SQL_INSERT);
			ps.setString(1, _snippet.getId());
			ps.setString(2, _snippet.getTitle());
			ps.setString(3, _snippet.getCode());
			ps.setDate(4, new Date(createdTime));
			ps.setDate(5, new Date(modifiedTime));
			return ps;
		});

		return _snippet;
	}

	public List<Snippet> findAll() {
		return this.jdbcTemplate.query(SQL_QUERY_ALL, rowMapper);
	}

	public Snippet findOne(String id) {
		return this.jdbcTemplate
				.queryForObject(SQL_QUERY_BY_ID, new Object[] { id },
						rowMapper);
	}

	public Snippet update(Snippet snippet) {
		assert snippet.getTitle() != null;
		assert snippet.getCode() != null;

		Snippet snippetFromRepo = findOne(snippet.getId());
		snippetFromRepo.setModified(new java.util.Date());
		snippetFromRepo.setTitle(snippet.getTitle());
		snippetFromRepo.setCode(snippet.getCode());
		save(snippetFromRepo);
		return snippetFromRepo;
	}

	public List<Snippet> save(List<Snippet> snippets) {
		List<Snippet> snippetsSaved = new ArrayList<>();
		for (Snippet snippet : snippets) {
			snippetsSaved.add(save(snippet));
		}
		return snippetsSaved;
	}
}

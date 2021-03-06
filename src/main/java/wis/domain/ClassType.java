package wis.domain;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Where;

//TipNastave

@Entity
@Where(clause = "deleted = 'false'")
public class ClassType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(max = 50)
	private String name;

	@NotNull
	private Boolean deleted = false;

	@Version
	private int version = 0;

	@OneToMany(mappedBy = "classType", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<CourseTeaching> courseTeaching;

	public ClassType() {

	}

	public ClassType(@Size(max = 50) String name, @NotNull Boolean deleted, int version,
			Set<CourseTeaching> courseTeaching) {
		super();
		this.name = name;
		this.deleted = deleted;
		this.version = version;
		this.courseTeaching = courseTeaching;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Set<CourseTeaching> getCourseTeaching() {
		return courseTeaching;
	}

	public void setCourseTeaching(Set<CourseTeaching> courseTeaching) {
		this.courseTeaching = courseTeaching;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ClassType object = (ClassType) o;
		if (object.id == null || id == null) {
			return false;
		}
		return Objects.equals(id, object.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

}

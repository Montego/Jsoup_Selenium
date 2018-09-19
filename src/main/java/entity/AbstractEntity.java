package entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractEntity extends AbstractPersistable<Long> {

}

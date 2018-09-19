package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name="serials")
public class Serial extends AbstractEntity{
    @Column(nullable = false)
    private String name_rus;

    @Column
    private String name_eng;

    @Column(nullable = false)
    private String link;

    @Column
    private Float rate;

    @Column
    private String description;


}

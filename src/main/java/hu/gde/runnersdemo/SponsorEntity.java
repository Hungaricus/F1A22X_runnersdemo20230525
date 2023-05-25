package hu.gde.runnersdemo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import hu.gde.runnersdemo.RunnerEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sponsors")
public class SponsorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sponsorId;

    @Column(name = "sponsor_name", nullable = false)
    private String sponsorName;

    @OneToMany(mappedBy = "sponsor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RunnerEntity> runners = new ArrayList<>();

    public Long getSponsorId() {
        return sponsorId;
    }

    public void setSponsorId(Long sponsorId) {
        this.sponsorId = sponsorId;
    }

    public String getSponsorName() {
        return sponsorName;
    }

    public void setSponsorName(String sponsorName) {
        this.sponsorName = sponsorName;
    }

}
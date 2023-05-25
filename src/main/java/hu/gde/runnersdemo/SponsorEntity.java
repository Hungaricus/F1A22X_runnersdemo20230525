package hu.gde.runnersdemo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sponsors")
public class SponsorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sponsorId;


    @JsonIgnore
    @OneToMany(mappedBy = "sponsor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RunnerEntity> runners = new ArrayList<>();

    @Column(name = "sponsor_name", nullable = false)
    private String sponsorName;



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

    public List<RunnerEntity> getRunners() {
        return runners;
    }

    public void setRunners(List<RunnerEntity> runners) {
        this.runners = runners;
    }
}

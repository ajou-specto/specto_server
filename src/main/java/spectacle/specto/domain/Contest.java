package spectacle.specto.domain;

import jakarta.persistence.*;
import lombok.*;
import spectacle.specto.domain.enumType.Field;

import java.time.LocalDate;

@Entity
@Table(name = "contest")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Contest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contest_id")
    private Long id;

    @Column(nullable = false)
    private String host;

    @Column(nullable = false)
    private Field field;

    @Lob
    @Column(length = 1000)
    private byte[] documentation;

    private Boolean awardStatus;

    private String awardTitle;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "spec_id", nullable = false)
    private Spec spec;

    @Builder
    public Contest(String host, Field field, byte[] documentation, Boolean awardStatus, String awardTitle, LocalDate date) {
        this.host = host;
        this.field = field;
        this.documentation = documentation;
        this.awardStatus = awardStatus;
        this.awardTitle = awardTitle;
        this.date = date;
    }
}

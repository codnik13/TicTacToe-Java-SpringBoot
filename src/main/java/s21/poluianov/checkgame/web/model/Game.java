package s21.poluianov.checkgame.web.model;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name="game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    @Column(name="status")
    int status=0;
    @Column(name="field_0")
    int field_0='\0';
    @Column(name="field_1")
    int field_1='\0';
    @Column(name="field_2")
    int field_2='\0';
    @Column(name="field_3")
    int field_3='\0';
    @Column(name="field_4")
    int field_4='\0';
    @Column(name="field_5")
    int field_5='\0';
    @Column(name="field_6")
    int field_6='\0';
    @Column(name="field_7")
    int field_7='\0';
    @Column(name="field_8")
    int field_8='\0';
    @Column(name = "delete")
    int delete=-1;
    @Column(name = "canceled")
    boolean canceled=false;
    @Column(name="turn")
    int turn=-1;

    public int getTurn() {
        return turn;
    }
    public void setTurn(int turn) {
        this.turn = turn;
    }
    public UUID getId() {
        return id;
    }
    public int getField_0() {
        return field_0;
    }
    public void setField_0(int field_0) {
        this.field_0 = field_0;
    }
    public int getField_1() {
        return field_1;
    }
    public void setField_1(int field_1) {
        this.field_1 = field_1;
    }
    public int getField_2() {
        return field_2;
    }
    public void setField_2(int field_2) {
        this.field_2 = field_2;
    }
    public int getField_3() {
        return field_3;
    }
    public void setField_3(int field_3) {
        this.field_3 = field_3;
    }
    public int getField_4() {
        return field_4;
    }
    public void setField_4(int field_4) {
        this.field_4 = field_4;
    }
    public int getField_5() {
        return field_5;
    }
    public void setField_5(int field_5) {
        this.field_5 = field_5;
    }
    public int getField_6() {
        return field_6;
    }
    public void setField_6(int field_6) {
        this.field_6 = field_6;
    }
    public int getField_7() {
        return field_7;
    }
    public void setField_7(int field_7) {
        this.field_7 = field_7;
    }
    public int getField_8() {
        return field_8;
    }
    public void setField_8(int field_8) {
        this.field_8 = field_8;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public int getDelete() {
        return delete;
    }
    public void setDelete(int delete) {
        this.delete = delete;
    }
    public boolean isCanceled() {
        return canceled;
    }
    public void setCanceled() {
        this.canceled = !canceled;
    }
}

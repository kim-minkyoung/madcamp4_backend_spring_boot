package com.example.madcamp4_backend.madcamp4_backend.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")  // 데이터베이스 컬럼 이름에 맞게 설정
    private Long id;

    @Column(name = "user_name", nullable = false, unique = true)
    private String name;

    @Column(name = "user_dorm")
    private String dorm;

    @Column(name = "user_password", nullable = false)
    private String password;  // 해싱된 비밀번호를 저장

    // 기본 생성자
    public User() {}

    // 모든 필드를 포함하는 생성자 (선택적)
    public User(String name, String password, String dorm) {
        this.name = name;
        this.password = password;
        this.dorm = dorm;
    }

    // Getter 및 Setter 메소드
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getDorm() {
        return dorm;
    }

    public void setDorm(String dorm) {
        this.dorm = dorm;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package l7_hibernate_hierarchy.table_per_class_hierarchy;

import jakarta.persistence.EntityManager;
import l6_hibernate.HibernateUtil;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();

        HomeTask homeTask = HomeTask.builder()
                .name("home_task_1")
                .description("to_do_home_task_1")
                .startDate(LocalDate.now())
                .endDate(LocalDate.now().plusDays(2))
                .build();

        Address address = Address.builder()
                .city("Minsk")
                .street("Nemiga")
                .build();
        Address homeAddress = Address.builder()
                .city("Vitebsk")
                .street("Lenina")
                .build();

        homeTask.setAddress(address);
        homeTask.setHomeAddress(homeAddress);

        entityManager.persist(homeTask);

        WorkTask workTask = WorkTask.builder()
                .name("work_task_1")
                .description("to_do_work_task_1")
                .cost(250.00)
                .build();

        entityManager.persist(workTask);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}

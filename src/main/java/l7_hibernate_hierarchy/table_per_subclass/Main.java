package l7_hibernate_hierarchy.table_per_subclass;

import jakarta.persistence.EntityManager;
import l6_hibernate.HibernateUtil;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();

        HomeTask1 homeTask = HomeTask1.builder()
                .name("home_task_2")
                .description("to_do_home_task_2")
                .startDate(LocalDate.now())
                .endDate(LocalDate.now().plusDays(2))
                .build();

        Address address = Address.builder()
                .city("Minsk")
                .street("Makaenka")
                .build();
        Address homeAddress = Address.builder()
                .city("Vitebsk")
                .street("Pushkina")
                .build();

        homeTask.setAddress(address);
        homeTask.setHomeAddress(homeAddress);

        entityManager.persist(homeTask);

        WorkTask1 workTask = WorkTask1.builder()
                .name("work_task_2")
                .description("to_do_work_task_2")
                .cost(160.00)
                .build();

        entityManager.persist(workTask);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}

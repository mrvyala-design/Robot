package l7_hibernate_hierarchy.table_per_concrete_class_mapping;

import jakarta.persistence.EntityManager;
import l6_hibernate.HibernateUtil;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();

        HomeTask2 homeTask = HomeTask2.builder()
                .name("home_task_3")
                .description("to_do_home_task_3")
                .startDate(LocalDate.now())
                .endDate(LocalDate.now().plusDays(2))
                .build();

        Address address = Address.builder()
                .city("Gomel")
                .street("Makaenka")
                .build();
        Address homeAddress = Address.builder()
                .city("Brest")
                .street("Pushkina")
                .build();

        homeTask.setAddress(address);
        homeTask.setHomeAddress(homeAddress);

        entityManager.persist(homeTask);

        WorkTask2 workTask = WorkTask2.builder()
                .name("work_task_3")
                .description("to_do_work_task_3")
                .cost(980.00)
                .build();

        entityManager.persist(workTask);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}

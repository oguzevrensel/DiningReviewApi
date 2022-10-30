package com.example.DiningReviewApi.diningreviewapi.diningReview;

import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<DiningReview, Long> {

    Iterable<DiningReview> findByIdAndAdminReviewStatus(Long id, AdminReviewStatus status);
    Iterable<DiningReview> findByAdminReviewStatus(AdminReviewStatus pending);
}

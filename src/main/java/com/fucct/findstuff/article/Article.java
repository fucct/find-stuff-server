package com.fucct.findstuff.article;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fucct.findstuff.base.BaseEntity;
import com.fucct.findstuff.comment.Comment;
import com.fucct.findstuff.common.ImageUrl;
import com.fucct.findstuff.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = false)
@Entity
@Getter
public class Article extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Size(max = 50)
    private String title;

    @NotBlank
    @Size(max = 2000)
    private String content;

    @Builder.Default
    @ElementCollection
    @CollectionTable(name = "article_images", joinColumns = @JoinColumn(name = "article_id"))
    @NotNull
    private List<ImageUrl> images = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    @NotNull
    private Member member;

    @Builder.Default
    @OneToMany
    @JoinColumn(name = "article_id")
    @NotNull
    private List<Comment> comments = new ArrayList<>();

    public void modifyArticle(String newTitle, String newContent) {
        this.title = newTitle;
        this.content = newContent;
    }
}

package com.even.wj.web;

import com.even.wj.domain.Book;
import com.even.wj.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 图书馆控制器
 */
@RestController
@CrossOrigin
public class LibraryController {

    @Autowired
    private BookService bookService;

    /**
     * 功能：获取所有书籍，并按id排序
     *
     * @return
     */
    @GetMapping("/api/books")
    public List<Book> list() {
        List<Book> list = bookService.list();
        return list;
    }

    /**
     * 功能：新增或更新书籍
     *
     * @param book
     * @return
     */
    @PostMapping("/api/addBooks")
    public Book addOrUpdate(@RequestBody Book book) {
        bookService.addOrUpdate(book);
        return book;
    }

    /**
     * 功能：根据id删除书籍
     *
     * @param book
     */
    @PostMapping("/api/delete")
    public void deleteById(@RequestBody Book book) {
        bookService.deletebyId(book.getId());
    }

    /**
     * 功能：获取某种类下所有书籍
     * @param cid
     * @return
     */
    @GetMapping("/api/categories/{cid}/books")
    public List<Book> listByCategory(@PathVariable("cid") int cid) {
        if (0 != cid) {
            return bookService.listByCategory(cid);
        } else {
            return list();
        }
    }
}

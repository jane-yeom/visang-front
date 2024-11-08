import com.visang.front.b2b.board.domain.Board;
import com.visang.front.b2b.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardApiController {

   private final BoardService boardService;

   // 게시글 작성
   @PostMapping
   public String save(@RequestBody Board board) {
       boardService.save(board);
       return "게시글이 작성되었습니다.";
   }

   // 게시글 수정
   @PutMapping("/{id}")
   public String update(@PathVariable Long id, @RequestBody Board board) {
       board.setId(id);
       boardService.update(board);
       return "게시글이 수정되었습니다.";
   }

   // 게시글 삭제
   @DeleteMapping("/{id}")
   public String delete(@PathVariable Long id) {
       boardService.delete(id);
       return "게시글이 삭제되었습니다.";
   }
}
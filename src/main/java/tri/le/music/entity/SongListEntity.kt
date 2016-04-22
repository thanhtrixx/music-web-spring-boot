package tri.le.music.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * Created by TriLe on 3/12/2016.
 */
@Entity
data class SongListEntity(

        var name: String = "",

        var description: String = "",

        var url: String = "",

        var imageUrl: String = "",

        var type: SongListType = SongListType.Album
) {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    enum class SongListType {
        Album, Playlist
    }
}
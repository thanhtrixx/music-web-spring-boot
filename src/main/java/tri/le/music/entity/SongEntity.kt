package tri.le.music.entity

import javax.persistence.*

/**
 * Created by TriLe on 3/5/2016.
 */
@Entity
data class SongEntity(
        var name: String = "",

        var description: String = "",

        @ManyToOne
        var album: AlbumEntity? = null,

        @ManyToOne
        var artist: HumanEntity? = null,

        @ManyToOne
        var composer: HumanEntity? = null,

        var genres: String = ""
) {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

    constructor(name: String, album: AlbumEntity?) : this(name, "", album, null, null, "")

    constructor(name: String) : this(name, null)

    constructor() : this("")
}

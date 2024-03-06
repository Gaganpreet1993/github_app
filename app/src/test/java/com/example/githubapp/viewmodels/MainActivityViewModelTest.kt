import com.example.githubapp.data.UserEntityData
import com.example.githubapp.domain.RepoInteractor
import com.example.githubapp.domain.UserInteractor
import com.example.githubapp.ui.mainScreen.MainActivityViewModel
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner
import rx.Observable
import rx.schedulers.TestScheduler

@RunWith(RobolectricTestRunner::class)
class MainActivityViewModelTest {

    // Subject under test
    private lateinit var viewModel: MainActivityViewModel

    // Mocks
    @Mock
    private lateinit var userInteractor: UserInteractor
    @Mock
    private lateinit var repoInteractor: RepoInteractor

    // Scheduler for testing RxJava
    private val testScheduler = TestScheduler()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = MainActivityViewModel(userInteractor, repoInteractor)
    }

    @Test
    fun `fetchUserInfo() should update live data with user information`() {
        val userId = "testUserId"
        val expectedUserName = "Test User"
        val expectedUserPhotoUrl = "https://example.com/test.jpg"

        val userEntityList = listOf(UserEntityData(expectedUserName, 123, expectedUserPhotoUrl))
        `when`(userInteractor.getUsers(userId)).thenReturn(Observable.just(userEntityList).subscribeOn(testScheduler))

        viewModel.fetchUserInfo(userId)

        testScheduler.triggerActions()

        assert(viewModel.userName.value == expectedUserName)
        assert(viewModel.userPhoto.value == expectedUserPhotoUrl)
    }
}

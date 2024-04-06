 # God Bless

Это проект первого модуля буткемпа под кодовым названием "God Bless" 
В этом проекте мы будем выполнять все задачи, относящиеся к первому модулю.

# Как начать работу
1. Склонируйте репозиторий к себе на компьютер
`git clone https://github.com/CorporationX/god_bless.git`
2. Откройте проект в Intellij IDEA. Используйте наши уроки по работе с Git & Git for IDEA, чтобы сделать все красиво
3. Создайте ветку с названием `ваш_ник_в_дискорде`. Это будет ваша ветка на весь модуль. Все изменения вы будете коммитить в нее. После создания ветки, запушьте ее на GitHub. ctrl + shift + k в IDEA. Теперь она доступна удаленно.
4. Когда берете новую задачу, из вашей основной ветки, которую вы создали на предыдущем шаге, создайте новую ветку с названием `ваш_ник_в_дискорде-название_задачи`. Название можно сократить или сделать таким, чтобы было понятно именно вам. Не нужно писать все огромное название, чтобы не запутаться. Названия всех веток должны быть на латинице. Все изменения по задаче вы будете коммитить в эту ветку.
5. Именно в этой новой ветке вы пишите код и выполняете конкретную задачу. Можете создавать в проекте любые пакеты и классы, что вам нужны для решения. Но я рекомендую под каждую задачу создавать отдельный пакет, который будет иметь относящееся к задаче имя, и всю разработку в рамках одной задачи вести именно в нем.

# Как сдавать задачи
1. Когда вы выполнили задачу, вам нужно закоммитить все изменения в вашу ветку. Для этого в IDEA есть вкладка Git, в которой вы можете выбрать все изменения, которые вы хотите закоммитить, и сделать коммит. В сообщении коммита укажите название задачи, которую вы выполнили, и дополнительную информацию лично от вас по решению, если необходимо.
2. После коммита пушим эти изменения в вашу ветку `ваш_ник_в_дискорде-название_задачи`. Теперь они доступны удаленно
3. Чтобы отправить эти изменения на проверку, отправляемся на GitHub и создаем Pull Request из ветки `ваш_ник_в_дискорде-название_задачи` в вашу ветку `ваш_ник_в_дискорде`. В описании к PR укажите название задачи, которую вы выполнили, и дополнительную информацию лично от вас по решению, если необходимо.
4. После создания PR двигайте задачу в Jira в статус review, но убедитесь, что ваш Pull Request отображается в задаче в Jira. В ближайшее время техлид отревьюит ваше решение и оставит комментарии по улучшению, если необходимо :) 
5. После завершения ревью, если ваше решение требует исправлений, то техлид оставит комментарии и переведет задачу в статус in progress в Jira. Если же все решено верно и нет комментариев для улучшения, то ваша задача окажется в статусе done. 
6. Если вы получили комментарии на ревью, то возвращаемся в вашу ветку `ваш_ник_в_дискорде-название_задачи`, чиним все необходимое и повторяем процесс коммита и пуша. Pull Request в этом случае автоматически обновится после пуша.
7. Если техлид аппрувнул ваш Pull Request, то он должен смержить его в вашу основную ветку - нажать зеленую кнопочку на GitHub в вашем Pull Request.
8. Когда берете следующую задачу, то создаете под нее новую ветку именно из ветки `ваш_ник_в_дискорде`, а не из ветки другой задачи. Это позволит вам вести разработку нескольких задач параллельно и не блокироваться во время ревью их техлидами.

# ВАЖНО
Это Gradle проект. В него уже подключен Lombok. Используйте его по максимуму, если умеете. Если нет, то рекомендуем почитать доку и посмотреть короткий туториал на YouTube по вашему выбору. Кода будет меньше - ревьюить сможем быстрее.
В проекте используется Java 17. Если у вас не установлена эта версия, то установите ее. Если не знаете как, то погуглите. Если не получается, то пишите в чатик в Discord.
